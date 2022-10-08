package italo.g2dlib.g2d.norm;

public class Normalizer {

	private float maximunValue = 1.0f;
	private NormalizerDriver driver;
	
	public Normalizer( NormalizerDriver driver ) {
		this.driver = driver;
	}
	
	public float normal( float value ) {
		if( value == 0 )
			return 0;
		return ( value / Math.abs( value ) ) * ( ( Math.abs( value ) * maximunValue ) / ( driver.screenHeight() *.5f ) ); 
	}
	
	public float value( float normal ) {
		if( normal == 0 )
			return 0;
		return ( normal / Math.abs( normal ) ) * ( ( Math.abs( normal ) * ( driver.screenHeight() * .5f ) ) / maximunValue );
	}

	public float getMaximunValue() {
		return maximunValue;
	}

	public void setMaximunValue(float maximunValue) {
		this.maximunValue = maximunValue;
	}

}
