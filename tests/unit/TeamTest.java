package unit;

import model.HumanPlayer;
import model.Player;
import model.Team;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class TeamTest {

	@Test
	public void canCreateATeam() {
        LinkedList<Player> members = new LinkedList<Player>();

        Player player1, player2;
        player1 = new HumanPlayer( 1 );
        player2 = new HumanPlayer( 2 );

        members.add( player1 );
        members.add( player2 );

		Team team = new Team( members );
	}

	@Test
    public void teamKnowsItsPlayers(){


        LinkedList<Player> newMembers = new LinkedList<Player>();

        Player player1, player2;
        player1 = new HumanPlayer( 1 );
        player2 = new HumanPlayer( 2 );

        newMembers.add( player1 );
        newMembers.add( player2 );

        Team team = new Team( newMembers );

        Assert.assertTrue( team.isMember(player1) );
    }

}
