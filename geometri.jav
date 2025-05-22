
        
        <script type="module">
        
          import * as THREE from 'three'; 
          import {OrbitControls} from 'controls' ;
          import {GLTFLoader} from 'loader';
        
            const scene = new THREE.Scene();
            const camera = new THREE.PerspectiveCamera( 75, window.innerWidth / window.innerHeight, 0.1, 1000 );

            const renderer = new THREE.WebGLRenderer({alpha:true});
                renderer.setSize( window.innerWidth, window.innerHeight );
                document.body.appendChild( renderer.domElement );
            const box = document.querySelector('.box');
                box.appendChild(renderer,domElement);
            
            const controls = new OrbitControls( camera, renderer.domElement );

           // const geometry = new THREE.BoxGeometry();
           //const material = new THREE.MeshBasicMaterial( { color: 0x00ff00 } );
          // const cube = new THREE.Mesh( geometry, material );
           //scene.add( cube ); 

            camera.position.z = 5;
            camera.position.x = 4;
            camera.position.y = -1;

            const Ambientlight = new THREE.AmbientLight( 0xffffff, 1 ); // soft white light
                 scene.add( Ambientlight );
            const Pontlight = new THREE.PointLight( 0xff0000, 1, 100 );
                Pointlight.position.set( 50, 50, 50 );
                scene.add( Pointlight );


            const loader = new GLTFLoader();
             
                loader.load( 'scene.gltf',function ( gltf ) {
                gltf.scene.scale.set(30,30,30);
	            scene.add( gltf.scene );

              });
            

            function animate() {
	        requestAnimationFrame( animate );
            //cube.rotation.x += 0.01;
            //cube.rotation.y += 0.01;
	        renderer.render( scene, camera );
            }
            animate();
        </script>    
    </body>
</html>
