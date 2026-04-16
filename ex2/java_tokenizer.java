import java.util.*;

public class javaTokenizer {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a short program:");
        String javaProgram=in.nextLine();
        String delimiters = " (){}[];.,\n\t";
        StringTokenizer tokenizer = new StringTokenizer(javaProgram,delimiters);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        System.out.println(tokens);
         List<String> keywords=new ArrayList<>();
         Set<String> keywordset=new HashSet<>(Arrays.asList("class","public","static","void","String","main","break","char","default","do","else","float","for","if","return","switch"));
        for (String token : tokens) {
            if (keywordset.contains(token)) {
                keywords.add(token);
            }
        }


        System.out.println("-------MENU-------\n1.List of Keywords\n2.Uppercase & Lowercase\n3.Convert public to private\n4.Position of l in println\n5.Total number of word\n6.Exit\n------------------");
        while(true)
                  {
        System.out.println("Enter choice:");

                  int ch=in.nextInt();
        switch(ch)
        {
        case 1:
        {
        Collections.sort(keywords);
        System.out.println("Keywords in ascending order: " + keywords);
        break;
        }
        case 3:
        {
        String modifiedProgram = javaProgram.replace("public", "private");
        System.out.println("Modified program: " + modifiedProgram);
        break;
        }
        case 2:
        {
        javaProgram = javaProgram.replace("int", "INT");
        javaProgram = javaProgram.replace("HelloWorld", "helloworld");
        System.out.println("Program after modifications: " + javaProgram);
        break;
        }
        case 4:
        {
        String methodName = "println";
        int positionOfL = methodName.indexOf('l');
        String substringPrint = methodName.substring(0, 5);
        System.out.println("Position of 'l' in 'println': " + positionOfL);
        System.out.println("Substring 'print' from 'println': " + substringPrint);
        break;
        }
        case 5:
        {
                  StringTokenizer tk = new StringTokenizer(javaProgram,delimiters);
        // System.out.println("Total number of tokens in the program: " + tk.countTokens());
        break;
        }
        case 6:
        {
                System.out.println("Exiting..\n");
                return ;
        }
        default:
        {
                System.out.println("Enter vaild choice\n");
        }

        }
        }
    }
}
