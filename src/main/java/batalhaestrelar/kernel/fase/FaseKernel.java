package batalhaestrelar.kernel.fase;




public interface FaseKernel {
				
	public void upMoveCam( Fase fase );

	public void translateComputersByGroup( Fase fase );

	public void updateComputerInScreenList( Fase fase );
		
	public void updateBonusListInScreen( Fase fase );

	public void updateRandomNaveForShot( Fase fase );

	public void moveComputerGunshots( Fase fase );
	
	public void processMovePlayer( Fase fase );
	
	public void processShotedComputerNaves( Fase fase );
	
	public void processShotedPlayer( Fase fase );

	public void processEnemiesInColision( Fase fase );

	public void processBonusColision( Fase fase );
	
	public void removeOutScreenComputerGunshots( Fase fase );
			
	public FaseState state( Fase fase );
	
	public boolean isWin( Fase fase );
	
	public boolean isLastFaseCell( Fase fase );
	
}
