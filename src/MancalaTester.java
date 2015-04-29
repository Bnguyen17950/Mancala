/**
 * Created by bryannguyen on 4/13/15.
 */
public class MancalaTester
{
    public static void main(String[] args)
    {
        //Create Frame take user input
    

        Model model = new Model();
        model.initiatePits(1);  //user input
        Controller c = new Controller(model, new View());
        Controller c2 = new Controller(model, new View2());
    }
}
