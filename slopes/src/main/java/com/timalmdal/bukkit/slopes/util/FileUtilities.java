package com.timalmdal.bukkit.slopes.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spout.Spout;
import org.getspout.spoutapi.SpoutManager;

public enum FileUtilities {
	;

	public static File getTempResourceFile(final String fileName) {
		final File tempDirectory = new File(Spout.getInstance().getDataFolder(), "temp");
		if (!tempDirectory.exists()) {
			tempDirectory.mkdirs();
		}
		return new File(tempDirectory, fileName);
	}

	public static File loadResource(final String resourceName) throws IOException {
		final File resourceFile = getTempResourceFile(resourceName);

		fastChannelCopy(Channels.newChannel(FileUtilities.class.getClassLoader().getResourceAsStream(resourceName)),
			Channels.newChannel(new FileOutputStream(resourceFile)));

		return resourceFile;
	}

	public static void fastChannelCopy(final ReadableByteChannel resourceSource, final WritableByteChannel resourceTarget) throws IOException {
		final ByteBuffer buffer = ByteBuffer.allocateDirect(32 * 1024 * 1024);
		while (resourceSource.read(buffer) != -1) {
			buffer.flip();
			resourceTarget.write(buffer);
			buffer.compact();
		}

		buffer.flip();
		while (buffer.hasRemaining()) {
			resourceTarget.write(buffer);
		}
		resourceSource.close();
		resourceTarget.close();
	}

	public static String loadAndCacheResource(final JavaPlugin plugin, final String resourceName) throws IOException {
		final File resourceFile = FileUtilities.loadResource(resourceName);
		SpoutManager.getFileManager().addToCache(plugin, resourceFile);

		return resourceFile.getPath();
	}
}
