package com.epam.rd.autotasks;

public class TaskCarousel {
    private final int capacity;
    private int length = 0;
    private Task[] array;
    private int counter;

    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        array = new Task[length];
        counter = -1;
    }

    public boolean addTask(Task task) {
        if(length >= capacity || task.isFinished())
            return false;


        if(task instanceof CountDownTask && ((CountDownTask) task).getValue()==0)
            return false;

        length++;

        if(length == 1){
            array = new Task[length];
            array[0] = task;
            return true;
        }

        Task[] oldArray = array;
        array = new Task[length];

        if (length - 1 >= 0) System.arraycopy(oldArray, 0, array, 0, length - 1);

        array[length -1] = task;

        return true;
    }

    public void removeTask(int index){
        if(index < 0 || index >= length)
            return;

        length--;
        Task[] oldArray = array;

        array = new Task[length];

        int temp_i = 0;
        for (int i = 0; i < length && temp_i < length +1; temp_i++) {
            if(temp_i == index)
                continue;

            array[i] = oldArray[temp_i];
            i++;
        }
    }

    public boolean execute() {
        if (isEmpty())
            return false;

        counter++;

        if(counter >= array.length)
            counter = 0;

        Task currentTask = array[counter];

        if(currentTask != null && !currentTask.isFinished()){
            currentTask.execute();
            if(currentTask.isFinished()){
                removeTask(counter);
                counter--;
            }
            return true;
        }else return execute();
    }

    public boolean isFull() {
        return length == capacity;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }
}