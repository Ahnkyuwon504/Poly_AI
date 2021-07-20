import tensorflow as tf


result = tf.constant("Tensorflow is easy!!")
sess = tf.compat.v1.Session()
print(str(sess.run(result), encoding='utf-8'))

# 상수형  / 그대로 출력 / Tensor 출력됨

x = tf.constant(3)
print(x)

# 상수형  / session 객체를 사용하여 실행 후 출력 / value 출력됨

sess = tf.Session()
result = sess.run(x)
print(result)
print(sess.run(x))

# 변수 (에러)

"""
var_1 = tf.Variable(3)
var_2 = tf.Variable(10)
result_sum = var_1 + var_2
sess = tf.Session()
print(sess.run(result_sum))
"""

# 변수 (에러 해결)

var_1 = tf.Variable(3)
var_2 = tf.Variable(10)
result_sum = var_1 + var_2
init = tf.global_variables_initializer()
sess = tf.Session()
sess.run(init)
print(sess.run(result_sum))

# Placeholder

var_1 = 22
var_2 = 8

p_holder1 = tf.placeholder(dtype=tf.float32)
p_holder2 = tf.placeholder(dtype=tf.float32)
p_holder_sum = p_holder1 + p_holder2

sess = tf.Session()
result = sess.run(p_holder_sum, feed_dict={p_holder1: var_1, p_holder2: var_2})
print(result)

# Placeholder(array)

A = [1, 3, 5, 7, 9]
B = [2, 4, 6, 8, 10]

ph_A = tf.placeholder(dtype=tf.float32)
ph_B = tf.placeholder(dtype=tf.float32)
result_sum = ph_A + ph_B

sess = tf.Session()
result = sess.run(result_sum, feed_dict={ph_A: A, ph_B: B})
print(result)
