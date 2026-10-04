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

## On the target

The publisher and subscriber start automatically at boot as systemd services
(`py-pubsub-publisher` and `py-pubsub-subscriber`).

Check that they are running and see their output:

```bash
systemctl status py-pubsub-publisher py-pubsub-subscriber
journalctl -u py-pubsub-subscriber -f
```

Stop, start or disable them:

```bash
systemctl stop py-pubsub-publisher py-pubsub-subscriber
systemctl start py-pubsub-publisher py-pubsub-subscriber
systemctl disable py-pubsub-publisher py-pubsub-subscriber   # don't start at boot
```

Inspect the topic with the ROS 2 CLI:

```bash
source /opt/ros/lyrical/setup.sh
ros2 topic echo /counter/value
```

To run a node by hand (`ros2 run py_pubsub publisher`), stop its service first,
otherwise two instances run at the same time.
