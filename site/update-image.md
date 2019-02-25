# Update Image

The update command is used to apply patches to an existing WebLogic docker image. The required options for the command 
are marked with asterisk (*). Password can be provided in one of the three ways.
 
1) Plain Text
2) Environment Variable
3) File containing the password

```
Usage: imagebuilder update [OPTIONS]
Update WebLogic docker image with selected patches
      --docker=<dockerPath> path to docker executable. Default: docker
*     --fromImage=<fromImage>
                            Docker image to use as base image.
      --httpProxyUrl=<httpProxyUrl>
                            proxy for http protocol. Ex: http://myproxy:80 or http:
                              //user:passwd@myproxy:8080
      --httpsProxyUrl=<httpsProxyUrl>
                            proxy for https protocol. Ex: http://myproxy:80 or http:
                              //user:passwd@myproxy:8080
      --latestPSU           Whether to apply patches from latest PSU.
      --password=<password for support user id>
                            Password for support userId
      --passwordEnv=<environment variable>
                            environment variable containing the support password
      --passwordFile=<password file>
                            path to file containing just the password
      --patches=patchId[,patchId...]
                            Comma separated patch Ids. Ex: p12345678,p87654321
*     --tag=TAG             Tag for the final build image. Ex: store/oracle/weblogic:
                              12.2.1.3.0
*     --user=<support email>
                            Oracle Support email id
```

## Usage scenarios

**_Note: Use --passwordEnv or --passwordFile instead of --password_**

- Update an image named sample:1.0 by applying the latest psu and tag it as sample:1.1.
    ```
    imagebuilder update --fromImage sample:1.0 --tag sample:1.1 --latestPSU --user test@xyz.com --passwordEnv MYVAR
    ```

- Update an image named sample:1.0 with selected patches applied.
    ```
    imagebuilder update --fromImage sample:1.0 --tag sample:1.1 --user test@xyz.com --password hello --patches 12345678,p87654321
    ```
    The patch numbers may or may not start with 'p'.