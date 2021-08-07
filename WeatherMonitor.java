
/*
    Name: Zhiyu Gao
    PID:  A17245309
 */

/**
 * @author Zhiyu Gao
 * @since 8/7/2021
 */

public class WeatherMonitor {

    IntStack temps;

    public WeatherMonitor() {
        temps = new IntStack(10);
    }

    public int numDays(int temp) {
        /**
         * Calculate the consecutive number of days that that day's temp is hotter than
         * previous temperatures.
         * 
         * @param: temp: int, the current day's temperature.
         * @return: int, the consecutive number of days that that day's temp is hotter
         *          than previous temperatures.
         */
        IntStack temporary = new IntStack(10);
        int re = 0;
        while (!temps.isEmpty() && temp > temps.peek()) {
            temporary.push(temps.pop());
            ++re;
        }
        while (!temporary.isEmpty()) {
            temps.push(temporary.pop());
        }
        temps.push(temp);
        return re;
    }
}
