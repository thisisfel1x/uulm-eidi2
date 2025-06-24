package eidi2.sose25.weber.felix.lessons.examWithUML;

import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.Game;
import eidi2.sose25.weber.felix.lesson.zulassungsklausur.examWithUML.group01.util.InputManagement;

import java.util.ArrayList;
import java.util.Optional;

public class TestInputManagement extends InputManagement {
	private ArrayList<String> positions=new ArrayList<String>();



	public void setXyPosition(ArrayList<String> positions) {
		this.positions=positions;
	}
	
	public int[] manageInput(Game game) {
		int[] xyPosition= {-1,-1};
		if(positions.isEmpty()) {
			((TestGame)game).setWinner(Optional.of(game.getPlayers().get(0)));
			((TestGame)game).setTestWinner(true);
			return xyPosition;
		}
		String[] split=positions.remove(0).replaceAll(" ","").split("-");
		
		int x=Integer.parseInt(split[0]);
		int y=Integer.parseInt(split[1]);
				if((x>0)&&(x<=3)&&(y>0)&&(y<=3)&&game.isFieldFree(x,y)) {
					xyPosition[0]=x;
					xyPosition[1]=y;
				}
		return xyPosition;
	}

	public ArrayList<String> getPositions() {
		return positions;
	}

	public void setPositions(ArrayList<String> positions) {
		this.positions = positions;
	}

	
}
