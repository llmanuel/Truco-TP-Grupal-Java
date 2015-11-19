package unit;

import model.HumanPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import model.CircularLinkedList;

/**
 * Created by manuel on 19/11/15.
 */
public class CircularLinkedListTest {


    private CircularLinkedList<HumanPlayer> MyCircularList;
    private HumanPlayer humanPlayer;
    private HumanPlayer humanPlayer2;
    private HumanPlayer humanPlayer3;
    private HumanPlayer humanPlayer4;

    @Before
    public void setup(){
        MyCircularList = new CircularLinkedList<HumanPlayer>();
        humanPlayer = new HumanPlayer(1);
        humanPlayer2 = new HumanPlayer(2);
        humanPlayer3 = new HumanPlayer(3);
        humanPlayer4 = new HumanPlayer(4);
    }

    @Test
    public void ICanGoThroughtTheCircularList(){
        MyCircularList.addLast(humanPlayer);
        MyCircularList.addLast(humanPlayer2);
        MyCircularList.addLast(humanPlayer3);
        MyCircularList.addLast(humanPlayer4);

        Assert.assertEquals(1, humanPlayer.getIdNumber());

        Assert.assertEquals(2, humanPlayer2.getIdNumber());
        Assert.assertEquals(3, humanPlayer3.getIdNumber());
        Assert.assertEquals(4, humanPlayer4.getIdNumber());


        for(int i = 0; i == MyCircularList.getSize() ; i++){
            Assert.assertEquals(i+1, MyCircularList.get(i).getIdNumber());
        }

        HumanPlayer temporalHuman = MyCircularList.next();
        Assert.assertEquals(1, temporalHuman.getIdNumber());

        temporalHuman = MyCircularList.next();
        Assert.assertEquals(2, temporalHuman.getIdNumber());

        temporalHuman = MyCircularList.next();
        Assert.assertEquals(3, temporalHuman.getIdNumber());

        temporalHuman = MyCircularList.next();
        Assert.assertEquals(4, temporalHuman.getIdNumber());

}

    @Test
    public void ICanGoINCiclulesAtTheCircularList(){
        MyCircularList.addLast(humanPlayer);
        MyCircularList.addLast(humanPlayer2);
        MyCircularList.addLast(humanPlayer3);
        MyCircularList.addLast(humanPlayer4);

        Assert.assertEquals(1, MyCircularList.get(1).getIdNumber());
        Assert.assertEquals(2, MyCircularList.get(2).getIdNumber());
        Assert.assertEquals(3, MyCircularList.get(3).getIdNumber());
        Assert.assertEquals(4, MyCircularList.get(4).getIdNumber());

        Assert.assertEquals(1, MyCircularList.get(5).getIdNumber());
        Assert.assertEquals(2, MyCircularList.get(6).getIdNumber());
        Assert.assertEquals(3, MyCircularList.get(7).getIdNumber());
        Assert.assertEquals(4, MyCircularList.get(8).getIdNumber());

    }

}
