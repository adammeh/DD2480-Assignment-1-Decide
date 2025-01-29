package group6.service;

import group6.matrix.ConditionsMetVector;
import group6.model.LIC;
import group6.model.Parameters;
import group6.model.Point;

import java.util.List;

/**
 * Provides services for evaluating individual Launch Interceptor Conditions (LICs).
 */
public class LICService {

    private final LIC lic;

    /**
     * Constructs a new LIC service.
     */
    public LICService() {
        this.lic = new LIC();
    }

    /**
     * Evaluates a specific LIC by ID.
     *
     * @param licId      the ID of the LIC to evaluate (0-14)
     * @param points     the list of points
     * @param parameters the parameters for the evaluation
     * @return true if the condition is satisfied, false otherwise
     */
    public boolean evaluateLICById(int licId, List<Point> points, Parameters parameters) {
        switch (licId) {
            case 0:
                return lic.evaluateLIC0(points, parameters);
            case 3:
                return lic.evaluateLIC3(points, parameters);
            case 10:
                return lic.evaluateLIC10(points, parameters);
            case 14:
                return lic.evaluateLIC14(points, parameters);
            case 4:
                return lic.evaluateLIC4(points, parameters);
            case 5: 
                return lic.evaluateLIC5(points, parameters);
            case 7:
                return lic.evaluateLIC7(points, parameters);
            case 12:
                return lic.evaluateLIC12(points, parameters);
            case 2:
                return lic.evaluateLIC2(points, parameters);
            case 6:
                return lic.evaluateLIC6(points, parameters);
            case 9:
                return lic.evaluateLIC9(points, parameters);
            case 11:
                return lic.evaluateLIC11(points, parameters);
            default:
                throw new IllegalArgumentException("Invalid LIC ID: " + licId);
        }
    }


    /**
     * Evaluates all LICs and sets the results in the Conditions Met Vector (CMV).
     *
     * @param cmv        the Conditions Met Vector
     * @param points     the list of points
     * @param parameters the parameters for the evaluation
     */
    public void evaluateAllLICs(ConditionsMetVector cmv, List<Point> points, Parameters parameters) {
        for (int i = 0; i < 15; i++) {
            cmv.setConditionMet(i, evaluateLICById(i, points, parameters));
        }
    }
}
