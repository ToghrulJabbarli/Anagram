# Information about the prepared environment
## Requirements
1. Installed Java JDK
2. Installed Maven
3. Your IDE
4. Web browser
​
## Folders

1. `deploy`
    
    Configuration for the deployment process. Already configured, you do not need to edit, but feel free to edit.
​
2. `src/main/java`
​
    Java source files:
     - `jaxrs`: Java implementations for JSONObject and JSONArray read and write for JAX-RS
     - `hello`: Simple API tester class
     - `anagram`: Your implementation goes here
  
3. `src/main/webapp`
    
    Web application home folder.
​
4. `src/test`
    
    Test implementations.
​
## Start and test the webserver
1. Run the following command in this folder to start the server:
​
    ```bash
    mvn clean package liberty:run-server
    ```
​
2. Go to the browser:
   1. Load [this URL](http://localhost:9080/anagram) and you will see a big `It works` message
   2. Load [this URL](http://localhost:9080/anagram/api/hello) and you will see this JSON Object:
   
        ```json
        {"hello":"Hello"}
        ```
​
3. To stop the server just simply stop the command what you started in step 1.
​
## How to develop​
1. Start your webserver.
2. If you update the binaries, the Liberty server automatically applies your changes.
​
    To update the binaries use Compile in your IDE or use the following Maven command:
    ```bash
    mvn compile
    ```

    *Note*: Sometimes the Liberty stucks and not updates your changes, or stuck in a Liberty welcome page.
    
    For this there are two possible solutions:
    
    1. Liberty has encountered some exceptions. Solution: Restart the liberty (stop the running server command and run it again)
    2. The most possible is that you may have an exception in your code.
​
    To check this check to the `wlp/usr/servers/defaultServer/logs/messages.log` log file for further information.
​
3. To call your API directly from your browser use this base URL:
    
    `http://localhost:9080/api/`
​
## How to run your tests

1. Use your IDE to run tests
2. OR Run the following command:
   
    ```bash
    mvn clean test
    ```
