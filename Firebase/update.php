<!-- Juan Diego Gonzalez German
ID: 1001401837 -->

<?php
    $host = "localhost";
    $dbusername = "root";
    $dbpassword = "";
    $dbname = "doctoral";
    echo "<body style='background-color:whitesmoke'>";
    // Create connection
    $conn = new PDO('mysql:host='.$host.';dbname='.$dbname, 
                    $dbusername, $dbpassword);
    // Check connection
    if(!$conn) {
        die("Connection failed");
    }
    else {
        $id = filter_input(INPUT_POST, 'id');
        $type = filter_input(INPUT_POST, 'type');

        $query = "  UPDATE instructor SET Type = '$type'
                    WHERE InstructorId = '$id'";

        if ($conn->query($query)){
            echo "Record updated sucessfully";
        }

        else{
            echo "Error: ". $conn->errorInfo()[0];
        }
    }
?>