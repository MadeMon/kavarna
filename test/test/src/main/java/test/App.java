package test;
import java.util.HashMap;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        HashMap<Kolo,Integer> map = new HashMap();
        Kolo bmx = new Kolo(43);
        map.put(bmx, 3);
        bmx.cena = 1;
        System.out.print(map.key(bmx).cena);
    }
}
