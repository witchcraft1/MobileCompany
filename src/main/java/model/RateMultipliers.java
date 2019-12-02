package model;

public interface RateMultipliers {
    double INTERNET_MULTIPLIER = 0.01;
    double CALLS_WITHIN_NETWORK_MULTIPLIER = 0.015;
    double CALLS_TO_OTHER_NETWORK_MULTIPLIER = 0.5;
    double SMS_MULTIPLIER = 0.007;
    double roamingCostMultiplier = 2.0;
}
