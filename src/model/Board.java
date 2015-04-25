package model;

public class Board {

	private int[][] board;
	private int[] indexOfBlankTile;
	
	public Board(int[][] board) {
		super();
		this.board = new int[4][];
		for( int i=0; i<board.length; i++)
		this.board[i] = board[i].clone();
		this.indexOfBlankTile = getIndexOfBlankTile();
	}

	private int[] getIndexOfBlankTile(){
		for (int i = 0 ; i < 4; i++)
		    for(int j = 0 ; j < 4 ; j++)
		    {
		         if ( this.board[i][j] == 16)
		         {
		        	 int[] indexOfBlankTile = {i,j};
		        	 return indexOfBlankTile;
		         }
		    }
		return null;
	}
	
	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public void changeByDirection(Direction direction) throws WrongDirectionException
	{
		switch(direction){
		case DOWN:
			swapDown();
			break;
		case LEFT:
			swapLeft();
			break;
		case RIGHT:
			swapRight();
			break;
		case UP:
			swapUp();
			break;
		default:
			throw new WrongDirectionException();
		}
	}
	
	private void swapUp() throws WrongDirectionException
	{
		if(indexOfBlankTile[0]==0)
			throw new WrongDirectionException();
		else
		{
			int temporary = board[indexOfBlankTile[0]-1][indexOfBlankTile[1]];
			board[indexOfBlankTile[0]-1][indexOfBlankTile[1]]=16;
			board[indexOfBlankTile[0]][indexOfBlankTile[1]]=temporary;
			this.indexOfBlankTile = getIndexOfBlankTile();
		}
	}
	
	private void swapDown() throws WrongDirectionException
	{
		if(indexOfBlankTile[0]==3)
			throw new WrongDirectionException();
		else
		{
			int temporary = board[indexOfBlankTile[0]+1][indexOfBlankTile[1]];
			board[indexOfBlankTile[0]+1][indexOfBlankTile[1]]=16;
			board[indexOfBlankTile[0]][indexOfBlankTile[1]]=temporary;
			this.indexOfBlankTile = getIndexOfBlankTile();
		}
	}
	
	private void swapLeft() throws WrongDirectionException
	{
		if(indexOfBlankTile[1]==0)
			throw new WrongDirectionException();
		else
		{
			int temporary = board[indexOfBlankTile[0]][indexOfBlankTile[1]-1];
			board[indexOfBlankTile[0]][indexOfBlankTile[1]-1]=16;
			board[indexOfBlankTile[0]][indexOfBlankTile[1]]=temporary;
			this.indexOfBlankTile = getIndexOfBlankTile();
		}
	}
	
	private void swapRight() throws WrongDirectionException
	{
		if(indexOfBlankTile[1]==3)
			throw new WrongDirectionException();
		else
		{
			int temporary = board[indexOfBlankTile[0]][indexOfBlankTile[1]+1];
			board[indexOfBlankTile[0]][indexOfBlankTile[1]+1]=16;
			board[indexOfBlankTile[0]][indexOfBlankTile[1]]=temporary;
			this.indexOfBlankTile = getIndexOfBlankTile();
		}
	}
	
	public void printBoard(){
		for (int i = 0 ; i < 4; i++)
			{
			for(int j = 0 ; j < 4 ; j++)
			    {		        
			    	System.out.print(board[i][j] + " ");
			    }
			System.out.println();
			}
	}
	
	public boolean amIFinalNode(){
		if(board[0][0]==1)
		{
			int temp = 1;
			for (int i = 0 ; i < 4; i++)
				for(int j = 0 ; j < 4 ; j++)
				    {		        
				    	if (board[i][j]<temp)
				    		return false;
				    	temp=board[i][j];
				    }
			return true;
		}
		else
		return false;
	}
	
}
