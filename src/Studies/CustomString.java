package Studies;

public class CustomString {

    private final String str;
    private final String[] words;

    private final int size;

    public CustomString(String str){
        this.str = str;
        this.size = str.length();
        this.words = findAllWords();
    }

    public int[] getAllNumbers(){
        int[] numbersArray;
        int numbersCounter = 0;

        if (isOnlyNumbers()){
            numbersArray = new int[words.length];

            for (String word: words){
                numbersArray[numbersCounter++] = Integer.parseInt(word);
            }

        } else {
            for (String word: words){
                if (isNumber(word)){
                    numbersCounter++;
                }
            }

            numbersArray = new int[numbersCounter];

            numbersCounter = 0;

            for (String word: words){
                if (isNumber(word)){
                    numbersArray[numbersCounter++] = Integer.parseInt(word);
                }
            }
        }

        return numbersArray;
    }

    private String[] findAllWords(){
        char[] charArray = str.toCharArray();
        int counter = 0;

        String[] words;
        String word = "";

        for (int i=0; i<size; i++){
            if(charArray[i] == ' ' || i==size-1){
                if (charArray[i] != ' ' || i==size-1){
                    word += charArray[i];
                }

                if(!word.equals("")){
                    counter++;

                    word = "";
                }
            } else {
                word += charArray[i];
            }
        }
        words = new String[counter];

        counter = 0;

        for (int i=0; i<size; i++){
            if(charArray[i] == ' ' || i==size-1){
                if (charArray[i] != ' ' || i==size-1){
                    word += charArray[i];
                }

                if(!word.equals("")){
                    words[counter++] = word;

                    word = "";
                }
            } else {
                word += charArray[i];
            }
        }

        return words;
    }

    private boolean isNumber(String word){
        for (char ch: word.toCharArray()){
            if (!(ch>=48 && ch<=57)){

                return false;
            }
        }

        return true;
    }

    public boolean isOnlyNumbers(){
        for (String word: words){
            if (!isNumber(word)){

                return false;
            }
        }

        return true;
    }

    public String[] getWords() {
        return words;
    }

    public String getStr() {
        return str;
    }

    public int getSize() {
        return size;
    }
}
