import random
import time


def runtime(func):

    def wrapper(*args, **kwargs):
        t1 = time.time()
        result = func(*args, **kwargs)
        t2 = time.time()
        print("Runtime: ", t2 - t1)
        return result

    return wrapper


def quick_sort(nums):

    if not nums or len(nums) == 1:
        return nums

    rand = random.choice(nums)
    big = []
    small = []

    for num in nums:
        if num <= rand:
            small.append(num)
        else:
            big.append(num)

    return quick_sort(small) + quick_sort(big)


@runtime
def main():
    print(quick_sort([13, 100, 2, 25, 10]))

if __name__ == "__main__":

    main()