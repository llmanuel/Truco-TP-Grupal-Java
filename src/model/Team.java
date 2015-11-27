package model;

import model.Exceptions.PlayerDoesNotExistsException;

import java.util.LinkedList;

public class Team {
    LinkedList<Player> members;

    public Team(LinkedList<Player> newMembers) {
        this.members = newMembers;
    }

    public boolean isMember(Player player) {
        return this.members.contains( player );
    }

    public Player getFirstMember(){
        return  (this.members.getFirst());
    }

    public Player pollFirst(){
        return this.members.pollFirst();
    }

    public void addLast(Player newLastPlayer) {
        this.members.addLast(newLastPlayer);
    }

    public Player getMember(int i) throws PlayerDoesNotExistsException {

        for (Player actualPlayer :members) {

            if (actualPlayer.getIdNumber() == i) {

                return actualPlayer;
            }
        }
        throw new PlayerDoesNotExistsException();
    }
}
