def call(Map config=[:], Closure body) {
    node {
        git url: "https://github.com/werne2j/sample-nodejs"

        stage("Install"){
            sh "npm install"
        }
	
	stage("Test") {
	    sh "npm test"
	}

	stage("Deploy") {
	    if (config.deploy) {
// If the deploy is set to true by other teams, then run this step i.e to publish npm
		sh "npm publish"
	    }
	}
// this is a new method. This method helps to extend the variable by passing a block of code
	body()
    }
}
