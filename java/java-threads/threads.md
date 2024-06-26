# Threads

Java threads allow the execution of multiple tasks at the same time. This is achieved by creating multiple threads and running them concurrently. Threads are lightweight sub-processes that share the same memory space and can be executed in parallel.

The benefits of using threads include:
- **Improved performance**: Threads can be used to perform multiple tasks simultaneously, which can improve the overall performance of an application.
- **Responsive user interface**: By using threads, you can keep the user interface responsive while performing time-consuming tasks in the background.
- **Simplified programming**: Threads can simplify the programming of complex applications by allowing different tasks to be executed concurrently.

---
#### Glossary:
- **Thread**: A lightweight sub-process that can be executed concurrently with other threads.
- **Concurrency**: The ability of an application to execute multiple tasks at the same time.
- **Parallelism**: The ability of an application to execute multiple tasks simultaneously on multiple processors.

---

#### Process vs. Thread:

A process is an independent execution unit that has its own memory space, while a thread is a lightweight sub-process that shares the same memory space as other threads in the same process.

#### Thread States:

Threads can be in one of the following states:
- **New**: The thread has been created but has not yet started.
- **Runnable**: The thread is ready to run and waiting for the CPU.
- **Running**: The thread is currently executing.
- **Blocked**: The thread is waiting for a resource or event to become available.
- **Waiting**: The thread is waiting for another thread to perform a specific action.
- **Timed Waiting**: The thread is waiting for a specific amount of time.
- **Terminated**: The thread has completed its execution.

#### Multitasking vs. Multithreading:

Multitasking refers to the ability of an operating system to run multiple processes concurrently, while multithreading refers to the ability of a single process to run multiple threads concurrently.

#### Daemon vs Non-Daemon Threads:

- Daemon threads are background threads that run in the background and do not prevent the JVM from exiting. They run infrastructure-level background tasks.
- Non-daemon threads are foreground threads that prevent the JVM from exiting until they complete their execution. They are used for user-level tasks.

#### Thread Synchronization:

Thread synchronization is the process of coordinating the execution of multiple threads to ensure that they do not interfere with each other. This is achieved using synchronization mechanisms such as locks, semaphores, and monitors.

#### Thread Safety:

Thread safety refers to the ability of a program to execute multiple threads concurrently without causing data corruption or inconsistency. This is achieved by using thread-safe data structures and synchronization mechanisms.

#### Thread Pool:

A thread pool is a collection of pre-initialized threads that can be used to execute tasks concurrently. This can improve the performance of an application by reducing the overhead of creating and destroying threads.

#### Thread Local Storage:

Thread local storage allows each thread to have its own copy of a variable, which is not shared with other threads. This can be useful for storing thread-specific data.

---

### Implementing Threads in Java:

Threads can be implemented in Java by extending the `Thread` class or implementing the `Runnable` interface. The `Thread` class provides methods for creating, starting, and managing threads, while the `Runnable` interface provides a way to define the task that a thread will execute.

```java
// Extending the Thread class
class MyThread extends Thread {
    public void run() {
        // Task to be executed by the thread
    }
}

// Implementing the Runnable interface
class MyRunnable implements Runnable {
    public void run() {
        // Task to be executed by the thread
    }
}

// Creating and starting a thread
Thread thread1 = new MyThread();
thread1.start();

// Creating and starting a thread using a Runnable
Runnable runnable = new MyRunnable();
Thread thread2 = new Thread(runnable);
thread2.start();

// Using lambda expression to define the task
Thread thread3 = new Thread(() -> {
    // Task to be executed by the thread
});
thread3.start();

// Pausing a thread
try {
    Thread.sleep(1000); // Sleep for 1 second
} catch (InterruptedException e) {
    e.printStackTrace();
}

// Interrupting a thread
thread1.interrupt();

// Checking if a thread is interrupted
if (Thread.interrupted()) {
    // Thread is interrupted
}

// interrupted vs isInterrupted
if (Thread.interrupted()) {
    // Thread is interrupted
}
if (thread1.isInterrupted()) {
    // Thread is interrupted
}

// Waiting for a thread to finish
try {
    thread1.join(); // Wait for thread1 to finish
} catch (InterruptedException e) {
    e.printStackTrace();
}

```

### Basic example:

```java

public class FirstThread extends Thread {

    private int number;

    public FirstThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for(int i = 1; i <=5 ; i++) {
            System.out.println(i + " from the thread " + number);
        }
    }
}


public class Main {
    public static void main(String[] args) {

        for(int count = 1; count <=3; count++) {
            FirstThread thread = new FirstThread(count);
            thread.start();
        }

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        thread.start();
    }
}
```

### Useful methods:

- `start()`: Starts the thread by calling the `run()` method.
- `run()`: Contains the code that will be executed by the thread.
- `sleep()`: Pauses the thread for a specified amount of time.
- `interrupt()`: Interrupts the thread, causing it to stop executing.
- `join()`: Waits for the thread to finish its execution.
- `isAlive()`: Checks if the thread is still running.
- `yield()`: Gives up the CPU to allow other threads to run.
- `setName()`: Sets the name of the thread.
- `getName()`: Gets the name of the thread.

### Thread Priority:

Threads can have a priority ranging from 1 to 10, with 1 being the lowest priority and 10 being the highest priority. The default priority is 5. The priority of a thread can be set using the `setPriority()` method.

```java
Thread thread = new Thread();
thread.setPriority(Thread.MAX_PRIORITY); // Set the priority to the maximum value
```

### Thread Group:
