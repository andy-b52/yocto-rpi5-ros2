import rclpy
from rclpy.node import Node
from std_msgs.msg import String


class Subsriber(Node):
    def __init__(self):
        super().__init__('subscriber')
        self.sub = self.create_subscription(String, 'counter/value', self.callback, 10)

    def callback(self, msg):
        self.get_logger().info(f'I heard: "{msg.data}"')


def main(args=None):
    rclpy.init(args=args)
    node = Subsriber()
    try:
        rclpy.spin(node)
    except KeyboardInterrupt:
        pass
    finally:
        node.destroy_node()
        rclpy.try_shutdown()


if __name__ == '__main__':
    main()