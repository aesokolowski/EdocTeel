class Solution {
    public String reorderSpaces(String text) {
        Integer spaceCount = 0,
                wordCount = 0;
        Integer spacesPerWord, remainingSpaces;
        List<String> wordList = new ArrayList<>();
        Character last = text.charAt(0);
        Boolean recordWord = false;
        String currWord = "",
               result = "";
        
        if (last == ' ') spaceCount++;
        else {
            wordCount++;
            recordWord = true;
            currWord = String.valueOf(last);
        }
        
        for (int i = 1; i < text.length(); i++) {
            Character ch = text.charAt(i);
            
            if (ch == ' ') {
                spaceCount++;
                if (recordWord) {
                    wordList.add(currWord);
                    recordWord = false;
                    currWord = "";
                }
            } else {
                if (recordWord) currWord = currWord.concat(String.valueOf(ch));
                else {
                    wordCount++;
                    recordWord = true;
                    currWord = String.valueOf(ch);
                }
            }
        }
        
        // in case non-space is last character:
        if (recordWord) wordList.add(currWord);
        
        // // debug:
        // System.out.println("\n***After Loop***");
        // System.out.println("spaceCount: " + spaceCount);
        // System.out.println("wordCount: " + wordCount);
        // System.out.println("currWord: " + currWord);  
        // System.out.println("wordList.toString(): " + wordList);
        
        if (wordCount > 1) {
            spacesPerWord = spaceCount / (wordCount - 1);
            remainingSpaces = spaceCount % (wordCount - 1);
            result = wordList.get(0);
            for (int i = 0; i < spacesPerWord; i++) result = result.concat(" ");
            for (int i = 1; i < wordCount; i++) {
                result = result.concat(wordList.get(i));
                if (i == (wordList.size() - 1)) {
                    for (int j = 0; j < remainingSpaces; j++) result = result.concat(" ");
                } else {
                    for (int j = 0; j < spacesPerWord; j++) result = result.concat(" ");
                }
            }
        } else {
            result = wordList.get(0);
            for (int i = 0; i < spaceCount; i++) result = result.concat(" ");
        }
        
        return result;
    }
}