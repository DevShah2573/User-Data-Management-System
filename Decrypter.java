public class Decrypter {
    public static void main(String[] args) {
        String data = "+1E2Z5CA6i00E7401dA8EFE)jC7IA8.G57";
        System.out.println(decrypt(data));
    }
    static String encrypt(String data){
        // for(int i = 0 ; i<data.length();) // logic to handle '"\ or space or =
        // String key =" !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~"; // removed: "' =\
        // "!#$%&()*+,-./0123456789:;<>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~" // also removed: /\:*?"<>|.
        


        //test key 1
        // String key = "!#$%&()+,-0123456789;@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{}~";
        //test key 2
        String key = "!#$%&()+0123456789@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]abcdefghijklmnopqrstuvwxyz{}";
        // (#addLater For Security,Store key in seprate file and Access it from there.)

        String encrypted_data = "";
        int key_length = key.length();
        for(char c : data.toCharArray()){
            int temp_char_index = key.indexOf(c);
            if(temp_char_index!=-1){
                encrypted_data += key.charAt(key_length-1-temp_char_index);
            }
            else{
                encrypted_data += c;
            }
        }        
        return encrypted_data;
    }
    static String decrypt(String data){
        return encrypt(data);
    }
}
