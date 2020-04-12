#Juan Diego Gonzalez German
#ID: 1001401837

#import modules
from socket import *
import threading
import sys

def handle_request(connection_socket):
    try:
        #decode the request and log it
        message = connection_socket.recv(1024).decode()
        print("request:", message)

        #ignore the request if it is not a GET HTTP request
        values = message.split()
        if values[0] != 'GET' or len(values) < 2:
            return

        #parse the filename from the request
        filename = values[1]
        #remove the leading '/' from web requests
        if filename[0] == '/':
            filename = filename[1:]
        #if no filename is given, return the deafult page
        if filename == '':
            filename = 'index.html'
        
        #open the file and extract the data
        with open (filename, 'r') as requested_file:
            file_data = requested_file.read()

        #create a status and header to top the sending of the html data in a HTTP format
        status = 'HTTP/1.1 200 OK' + '\r\n'
        header = 'Content-Type: text/html' + '\r\n'
        response = status + header + '\r\n'

        #add the requested file to the message
        response += file_data

        #send the data, close the connection, join the thread
        connection_socket.send(response.encode())
        connection_socket.close()

    #if the file is not present or I/O failed, send an unsuccesful HTTP response
    except IOError:
        status = 'HTTP/1.1 404 Not Found' + '\r\n'
        header = 'Content-Type: text/html' + '\r\n'
        response = status + header + '\r\n'

        connection_socket.send(status.encode())
        connection_socket.close()

if __name__ == "__main__":
    #define default port, change if specified when runninh
    port = 8080
    if len(sys.argv) > 1:
        port = int(sys.argv[1])

    #prepare and bind the socket, set it to accept 100 simultaneous connections
    server_socket = socket(AF_INET, SOCK_STREAM)
    server_socket.bind(('', port))
    server_socket.listen(100)
    print('Server is up and running!')
    #listen for connections
    while True:
        #when a conncection is requested, make it, and handle it in a different thread
        connection_socket, address = server_socket.accept()
        thread = threading.Thread(target=handle_request, args=(connection_socket,))
        thread.start()