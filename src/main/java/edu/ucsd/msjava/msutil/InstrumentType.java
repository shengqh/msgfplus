package edu.ucsd.msjava.msutil;

import edu.ucsd.msjava.params.ParamObject;

import java.util.LinkedHashMap;


public class InstrumentType implements ParamObject {
    private String name;
    boolean isHighResolution;
    private String description;

    private InstrumentType(String name, String description, boolean isHighResolution) {
        this.name = name;
        this.description = description;
        this.isHighResolution = isHighResolution;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getParamDescription() {
        return description;
    }

    public boolean isHighResolution() {
        return isHighResolution;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof InstrumentType)
            return this.name.equalsIgnoreCase(((InstrumentType) obj).name);
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    public static InstrumentType get(String name) {
        return table.get(name);
    }

    public static LinkedHashMap<String, InstrumentType> table = new LinkedHashMap<String, InstrumentType>();
    public static final InstrumentType LOW_RESOLUTION_LTQ;
    public static final InstrumentType TOF;
    public static final InstrumentType HIGH_RESOLUTION_LTQ;
    public static final InstrumentType QEXACTIVE;
//	public static final InstrumentType TRIPLETOF;

    public static InstrumentType[] getAllRegisteredInstrumentTypes() {
        return table.values().toArray(new InstrumentType[0]);
    }

    static {
        LOW_RESOLUTION_LTQ = new InstrumentType("LowRes", "Low-res LCQ/LTQ", false);
        HIGH_RESOLUTION_LTQ = new InstrumentType("HighRes", "Orbitrap/FTICR", true);
        TOF = new InstrumentType("TOF", "TOF", true);
        QEXACTIVE = new InstrumentType("QExactive", "Q-Exactive", true);
//		TRIPLETOF = new InstrumentType("TripleTOF", "TripleTOF 5600", true);

        table.put(LOW_RESOLUTION_LTQ.getName(), LOW_RESOLUTION_LTQ);
        table.put(HIGH_RESOLUTION_LTQ.getName(), HIGH_RESOLUTION_LTQ);
        table.put(TOF.getName(), TOF);
        table.put(QEXACTIVE.getName(), QEXACTIVE);
//		table.put(TRIPLETOF.getName(), TRIPLETOF);
    }

}
