# pybind11 names the extension module using the build host's Python suffix
# (_rosidl_buffer_py.cpython-312-x86_64-linux-gnu.so), so Python on the target can't import it
# and every `ros2 topic` command fails. python3targetconfig makes CMake use the target's
# Python config (…-aarch64-linux-gnu.so), the same fix meta-ros applies to rclpy.
inherit python3targetconfig
