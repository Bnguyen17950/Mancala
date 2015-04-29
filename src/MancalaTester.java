/**
 * Created by bryannguyen on 4/13/15.
 */
public class MancalaTester
{
    public static void main(String[] args)
    {
        //Create Frame take user input
        View view1 = new View();
        //View2 view2 = new View2();

        Model model = new Model();
        model.initiatePits(4);  //user input
        Controller c = new Controller(model, view1);
    }
}
