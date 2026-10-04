from setuptools import find_packages, setup

package_name = 'py_pubsub'

setup(
    name=package_name,
    version='0.1.0',
    packages=find_packages(exclude=['test']),
    data_files=[
        ('share/ament_index/resource_index/packages',
            ['resource/' + package_name]),
        ('share/' + package_name, ['package.xml']),
    ],
    # package_data={'': ['py.typed']},
    install_requires=['setuptools'],
    zip_safe=True,
    maintainer='Andriy',
    maintainer_email='andriy@example.com',
    description='Simple Python publisher/subscriber',
    license='Apache-2.0',
    # extras_require={
    #     'test': [
    #         'pytest',
    #     ],
    # },
    entry_points={
        'console_scripts': [
            'publisher = py_pubsub.publisher:main',
            'subscriber = py_pubsub.subscriber:main'
        ],
    },
)
