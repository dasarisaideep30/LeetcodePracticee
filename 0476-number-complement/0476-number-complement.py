class Solution:
    def findComplement(self, num):
        mask = 1
        
        # Create mask like 111... (same bit length as num)
        while mask <= num:
            mask <<= 1
        
        return (mask-1) ^ num