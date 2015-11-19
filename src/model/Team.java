package model;

import java.util.LinkedList;

public class Team {
    LinkedList<Player> members;

    public Team(LinkedList<Player> newMembers) {
        this.members = newMembers;
    }

    public boolean isMember(Player player1) {
        return this.members.contains( player1 );
    }
}
