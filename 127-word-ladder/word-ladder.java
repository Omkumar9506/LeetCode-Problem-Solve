class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        Set<String> set = new HashSet<>();
        int n = wordList.size();
        for(int i=0;i<n;i++)
             set.add(wordList.get(i));

        while(!queue.isEmpty())
        {
            String word = queue.peek().first;
            int steps = queue.peek().second;
            queue.poll();
            if(word.equals(endWord))return steps;
            for(int i=0;i<word.length();i++)
            {
                for(char ch = 'a';ch <= 'z';ch++)
                {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord))
                    {
                        set.remove(replacedWord);
                        queue.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String first;
    int second;
    Pair(String _first,int _second){
        this.first = _first;
        this.second = _second;
    }
}