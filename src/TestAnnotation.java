import annotation.FieldAnnotation;
import annotation.MyAnnotation;

/**
 * Created by shuaibc on 2015/4/12.
 */
public class TestAnnotation
{
    @FieldAnnotation("Hello,World")
    private String word;
    @MyAnnotation(name="word",value="Hello,World")
    public void display()
    {
        System.out.print(word);
    }
    public String getWord()
    {
        return word;
    }
    public void setWord(String word)
    {
        this.word = word;
    }
}
