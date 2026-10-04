# yocto-rpi5

Yocto (scarthgap) image for Raspberry Pi 5 with SSH and ROS 2 Lyrical,
including the `py_pubsub` ROS 2 Python package (`layers/meta-ros2-app`).

## Build

```bash
git clone --recursive <repo-url> yocto-rpi5
cd yocto-rpi5

# Keep only the meta-ros layers this build uses
git -C layers/meta-ros sparse-checkout set meta-ros-common meta-ros2 meta-ros2-lyrical

TEMPLATECONF=$PWD/layers/meta-ros2-app/conf/templates/default \
    source layers/poky/oe-init-build-env build
bitbake core-image-base
```

## Run on the target

```bash
source /opt/ros/lyrical/setup.sh
ros2 run py_pubsub publisher
ros2 run py_pubsub subscriber
```
