package bancoDados.dbPropertiesFiles;

import java.util.Base64;

public class FileConfigDecorator implements Base64Decorator {

    @Override
    public String Codifica(String data) {
        
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    @Override
    public String Decodifica(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }

}
