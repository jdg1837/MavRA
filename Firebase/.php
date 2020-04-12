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
        $fname = filter_input(INPUT_POST, 'fname');
        $lname = filter_input(INPUT_POST, 'lname');
        $id = filter_input(INPUT_POST, 'id');
        if ($query = "  SELECT InstructorId, FName, LName, Type
                        FROM instructor as ins
                        WHERE ((FName = '$fname' and LName = '$lname') or InstructorId = '$id')") {

            if($query==null){
                echo "No Record Available";
                die();
            }

            else{
                $stmt = $conn->prepare($query);
                $stmt->execute(array(':fname' => $fname, ':lname' => $lname, ':id' => $id));
                $rows = $stmt->fetchALL(PDO::FETCH_ASSOC);
                ?>
                <table style="width:100%">
                <tr align="left">
                    <th>FacultyId</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Instructor Type</th>
                </tr>
                <?php
                foreach ($rows as $row) {
                    echo "<tr align=\"left\">";
                    echo "<td>".$row["InstructorId"]."</td>";
                    echo "<td>".$row["FName"]."</td>";
                    echo "<td>".$row["LName"]."</td>";
                    echo "<td>".$row["Type"]."</td>";
                    echo "</tr>";
                }
            }
        }
    }
?>