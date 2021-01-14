class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (hours == 12 && minutes == 59) {
            hours = 1;
            minutes = 0;
        } else if (hours < 12 && minutes == 59) {
            minutes = 0;
            hours++;
        } else {
            minutes++;
        }


    }
}