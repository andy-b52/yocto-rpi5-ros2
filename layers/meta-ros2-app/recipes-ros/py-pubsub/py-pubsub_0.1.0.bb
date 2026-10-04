SUMMARY = "Simple Python publisher/subscriber"
LICENSE = "Apache-2.0"
# Points at the <license> line (line 8) of package.xml
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=82f0323c08605e5b6f343b05213cf7cc"

# Source lives in files/py_pubsub next to this recipe, plus the systemd units
SRC_URI = "file://py_pubsub/ \
           file://py-pubsub-publisher.service \
           file://py-pubsub-subscriber.service \
          "
S = "${WORKDIR}/py_pubsub"

ROS_BPN = "py_pubsub"
ROS_EXEC_DEPENDS = "rclpy std-msgs"
RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"
# The services source /opt/ros/lyrical/setup.sh, which ros-workspace provides
RDEPENDS:${PN} += "ros-workspace"

inherit ros_distro_lyrical
inherit ros_component
inherit ros_ament_python

# Start publisher and subscriber at boot
inherit systemd
SYSTEMD_SERVICE:${PN} = "py-pubsub-publisher.service py-pubsub-subscriber.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/py-pubsub-publisher.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/py-pubsub-subscriber.service ${D}${systemd_system_unitdir}/
}
