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

        $query1 = " DELETE FROM selfsupport
                    WHERE StudentId = '$id'";

        $query2 = " DELETE FROM phdstudent
                    WHERE StudentId = '$id'";

        if ($conn->query($query1) and $conn->query($query2)){
            echo "Record deleted sucessfully";
        }

        else{
            echo "Error: ". $conn->errorInfo()[0];
        }
    }
?>