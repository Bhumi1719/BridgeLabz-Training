import java.util.*;

public class VesselUtil {
    private List<Vessel> vesselList = new ArrayList<>();

    public List<Vessel> getVesselList() {
        return vesselList;
    }

    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }

    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId) {
        for(Vessel vessel : vesselList) {
            if(vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }

        return null;
    }

    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> result = new ArrayList<>();

        if(vesselList.isEmpty()) {
            return result;
        }

        double maxSpeed = vesselList.get(0).getAverageSpeed();

        for(Vessel v : vesselList) {
            if(v.getAverageSpeed() > maxSpeed) {
                maxSpeed = v.getAverageSpeed();
            }
        }

        for(Vessel v : vesselList) {
            if(v.getAverageSpeed() == maxSpeed) {
                result.add(v);
            }
        }

        return result;
    }
}
