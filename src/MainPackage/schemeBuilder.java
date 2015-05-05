package MainPackage;

import model.Direction;

public class schemeBuilder {

	public static Direction[] build(String scheme){
		Direction[] returnedDir = new Direction[4];
		for(int i=0; i<4; i++)
		{
			switch(scheme.charAt(i)){
			case 'L':
				returnedDir[i]=Direction.LEFT;
				break;
			case 'P':
				returnedDir[i]=Direction.RIGHT;
				break;
			case 'G':
				returnedDir[i]=Direction.UP;
				break;
			case 'D':
				returnedDir[i]=Direction.DOWN;
				break;
			}
		}
		return returnedDir;
	}

	public static Direction[] buildForDFS(String scheme){
		Direction[] returnedDir = new Direction[4];
		int j=3;
		for(int i=0; i<4; i++)
		{
			switch(scheme.charAt(j)){
			case 'L':
				returnedDir[i]=Direction.LEFT;
				break;
			case 'P':
				returnedDir[i]=Direction.RIGHT;
				break;
			case 'G':
				returnedDir[i]=Direction.UP;
				break;
			case 'D':
				returnedDir[i]=Direction.DOWN;
				break;
			}
			j--;
		}
		return returnedDir;
	}
	
}
