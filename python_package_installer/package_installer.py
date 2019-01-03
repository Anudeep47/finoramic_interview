import json
import sys
try:
    from pip import main as pipmain
except:
    from pip._internal import main as pipmain


def installer(req_file):
    with open(req_file) as file:
        try:
            reqs = json.load(file)
        except ValueError:
            print("Invalid JSON file")
            return
        packages = reqs.values()[0]
        # pipmain returns 1 for failed packages
        failed_packages = [package+"=="+version for package, version in packages.iteritems() if pipmain(['install', package+"=="+version])==1]
        if failed_packages:
            print("Failed Packages:\n")
            for pkg in failed_packages:
                print(str(pkg))
        else:
            print("Successfully installed")




if __name__ == "__main__":
    if len(sys.argv) == 1:
        print("Usage: {} <requirements_json_file>".format(sys.argv[0]))
        exit(1)

    installer(sys.argv[1])
