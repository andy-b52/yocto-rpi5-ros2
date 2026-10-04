import rclpy
from rclpy.node import Node
from std_msgs.msg import String


class Publisher(Node):
    def __init__(self):
        super().__init__('publisher')
        self.pub = self.create_publisher(String, 'counter/value', 10)
        self.count = 0
        self.timer = self.create_timer(1.0, self.tick)

    def tick(self):
        msg = String()
        msg.data = f'Counter: {self.count}'
        self.count += 1
        self.get_logger().info(f'Publishing: "{msg.data}"')
        self.pub.publish(msg)


def main(args=None):
    rclpy.init(args=args)
    node = Publisher()
    try:
        rclpy.spin(node)
    except KeyboardInterrupt:
        pass
    finally:
        node.destroy_node()
        rclpy.try_shutdown()


if __name__ == '__main__':
    main()