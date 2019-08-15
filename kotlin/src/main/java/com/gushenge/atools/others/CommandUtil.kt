package com.gushenge.atools.others

import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.IOException

class CommandUtil{

    fun getProperty(propName: String): String? {
        var value: String? = null
        val roSecureObj: Any?
        try {
            roSecureObj = Class.forName("android.os.SystemProperties")
                    .getMethod("get", String::class.java)
                    .invoke(null, propName)
            if (roSecureObj != null) value = roSecureObj as String?
        } catch (e: Exception) {
            value = null
        } finally {
            return value
        }
    }

    fun exec(command: String): String? {
        var bufferedOutputStream: BufferedOutputStream? = null
        var bufferedInputStream: BufferedInputStream? = null
        var process: Process? = null
        try {
            process = Runtime.getRuntime().exec("sh")
            bufferedOutputStream = BufferedOutputStream(process!!.outputStream)

            bufferedInputStream = BufferedInputStream(process.inputStream)
            bufferedOutputStream.write(command.toByteArray())
            bufferedOutputStream.flush()
            bufferedOutputStream.close()

            process.waitFor()

            return getStrFromBufferInputSteam(bufferedInputStream)
        } catch (e: Exception) {
            return null
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
            process?.destroy()
        }
    }

    companion object {

        private fun getStrFromBufferInputSteam(bufferedInputStream: BufferedInputStream?): String {
            if (null == bufferedInputStream) {
                return ""
            }
            val BUFFER_SIZE = 512
            val buffer = ByteArray(BUFFER_SIZE)
            val result = StringBuilder()
            try {
                while (true) {
                    val read = bufferedInputStream.read(buffer)
                    if (read > 0) {
                        result.append(String(buffer, 0, read))
                    }
                    if (read < BUFFER_SIZE) {
                        break
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return result.toString()
        }

    }
}
