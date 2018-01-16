package com.wisn.tools;


import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by wisn on 2017/10/15.
 */

public class AESUtils {

    private final static String TAG = "AESUtils";
    private final static String masterPassword = "pqe2";//密钥
    private final static String HEX = "0123456789ABCDEF";
    private final static byte[] masterPasswordByte = {'p', 'q', 'e', '2'};//密钥

    /**
     * 加密字符串
     *
     * @param msg 需要加密的字符串
     *
     * @return String 加密之后的字符串
     */
    public static String AesEncryption(String msg) {
        String encryptionMsg = "";
        try {
            encryptionMsg = encrypt(masterPassword, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptionMsg;
    }

    /**
     * 加密数据流
     *
     * @param buf 需要加密的流
     *
     * @return byte[] 加密之后的流
     */
    public static byte[] AesEncryption(byte[] buf) {
        try {
            return encryptByte(masterPasswordByte, buf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 解密字符串
     *
     * @param msg 需要解密的字符串
     *
     * @return String 解密之后的字符串
     */
    public static String AesDecryption(String msg) {
        String decryptionMsg = "";
        try {
            decryptionMsg = decrypt(masterPassword, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptionMsg;
    }

    /**
     * 解密数据流
     *
     * @param buf 需要解密的数据流
     *
     * @return byte[]
     */
    public static byte[] AesDecryption(byte[] buf) {
        try {
            return decryptByte(masterPasswordByte, buf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encrypt(String seed, String clearText)
            throws Exception {
        byte[] rawKey = getRawKey(seed.getBytes());
        byte[] result = encrypt(rawKey, clearText.getBytes());
        return toHex(result);
    }

    //加密字节流
    public static byte[] encryptByte(byte[] seed, byte[] clearText)
            throws Exception {
        byte[] rawKey = getRawKey(seed);
        return encrypt(rawKey, clearText);
    }

    //解密字符串
    public static String decrypt(String seed, String encrypted)
            throws Exception {
        byte[] rawKey = getRawKey(seed.getBytes());
        byte[] enc = toByte(encrypted);
        byte[] result = decrypt(rawKey, enc);
        return new String(result);
    }

    //解密字节流
    public static byte[] decryptByte(byte[] seed, byte[] encrypted)
            throws Exception {
        byte[] rawKey = getRawKey(seed);
        return decrypt(rawKey, encrypted);
    }

    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        sr.setSeed(seed);
        kgen.init(128, sr); // 192 and 256 bits may not be available
        return kgen.generateKey().getEncoded();
    }

    public static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        return cipher.doFinal(clear);
    }

    public static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        return cipher.doFinal(encrypted);
    }

    public static String toHex(String txt) {
        return toHex(txt.getBytes());
    }

    public static String fromHex(String hex) {
        return new String(toByte(hex));
    }

    public static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++)
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2),
                                        16).byteValue();
        return result;
    }

    public static String toHex(byte[] buf) {
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        int size = buf.length;
        for (int i = 0; i < size; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }
}
