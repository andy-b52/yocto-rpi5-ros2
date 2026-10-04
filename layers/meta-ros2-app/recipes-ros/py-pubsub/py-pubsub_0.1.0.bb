SUMMARY = "Simple Python publisher/subscriber"
LICENSE = "Apache-2.0"
# Points at the <license> line (line 8) of package.xml
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

# Source lives in files/py_pubsub next to this recipe
SRC_URI = "file://py_pubsub/"
S = "${WORKDIR}/py_pubsub"

ROS_BPN = "py_pubsub"
ROS_EXEC_DEPENDS = "rclpy std-msgs"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

inherit ros_distro_lyrical
inherit ros_component
inherit ros_ament_python
