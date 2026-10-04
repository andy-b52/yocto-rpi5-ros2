# rmw-zenoh-cpp needs zenoh-c (meta-zenoh, Rust) and clang (meta-clang).
# Not needed here: the default RMW is Fast DDS, so drop the Zenoh dependency.
ROS_BUILD_DEPENDS:remove = "rmw-zenoh-cpp"
