public int[] decode(int[] encoded) {
        int[] decoded = new int[encoded.length + 1];
        for (int i = 1; i < encoded.length; i = i + 2) {
             decoded[0] =  decoded[0] ^ encoded[i];
             decoded[0] =  decoded[0] ^ i;
             decoded[0] =  decoded[0] ^ i + 1;
        }
         decoded[0] =  decoded[0] ^ decoded.length;
        for (int i = 1; i < decoded.length; i++) {
            decoded[i] = decoded[i-1] ^ encoded[i-1];
        }
        return decoded;
    }