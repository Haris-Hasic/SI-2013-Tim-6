package ba.unsa.etf.si.app.fdss_aplikacija.klase;

public enum Hitnost {
	NISKA("Niska"),SREDNJA("Srednja"),VELIKA("Velika");
	private final String display;
    private Hitnost(String s) {
        display = s;
    }
    
    @Override
    public String toString()
    {
    	return display;
    }

}
